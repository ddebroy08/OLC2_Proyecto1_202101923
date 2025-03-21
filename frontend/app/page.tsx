'use client';
import { Editor } from '@monaco-editor/react';
import { useState, useRef } from 'react';

const API_URL = 'http://localhost:5120';

export default function Home() {
  const [code, setCode] = useState<string>('');
  const [error, setError] = useState<string>('');
  const [output, setOutput] = useState<string>('');
  const [astSvg, setAstSvg] = useState<string>('');
  const [isLoadingAst, setIsLoadingAst] = useState<boolean>(false);
  const astContainerRef = useRef<HTMLDivElement>(null);

  const handleExecute = async () => {
    try {
      const response = await fetch(`${API_URL}/compile`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ code }),
      });

      const data = await response.json();

      if (!response.ok) {
        throw new Error(data.error || 'Error desconocido');
      }

      setOutput(data.result);
      setError('');
    } catch (err) {
      setOutput('');
      setError(err instanceof Error ? err.message : 'Error desconocido');
    }
  };

  const handleCreateFile = () => {
    setCode('');
  };

  const handleOpenFile = async () => {
    const fileInput = document.createElement('input');
    fileInput.type = 'file';
    fileInput.accept = '.glt';
    fileInput.onchange = async (event) => {
      const target = event.target as HTMLInputElement | null;
      if (target && target.files) {
        const file = target.files[0];
        if (file) {
          const text = await file.text();
          setCode(text);
        }
      }
    };
    fileInput.click();
  };

  const handleSaveFile = async () => {
    const filename = prompt('Introduce el nombre del archivo (sin extensión):');
    if (filename) {
      const blob = new Blob([code], { type: 'text/plain' });
      const link = document.createElement('a');
      link.href = URL.createObjectURL(blob);
      link.download = `${filename}.glt`;
      link.click();
    }
  };

  const handleAST = async () => {
    if (!code.trim()) {
      setError('Por favor, ingresa código para generar el AST.');
      return;
    }

    setIsLoadingAst(true);
    setError('');
    
    try {
      const response = await fetch(`${API_URL}/compile/ast`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ code }),
      });

      if (!response.ok) {
        const errorData = await response.json();
        throw new Error(errorData.error || 'Error al generar el AST');
      }

      // Recibimos SVG como texto
      const svgText = await response.text();
      setAstSvg(svgText);
      
      // Mostrar el AST en la sección de salida
      setOutput('AST generado exitosamente. Visualizándolo abajo.');
      
      // Desplazarse al contenedor del AST
      if (astContainerRef.current) {
        astContainerRef.current.scrollIntoView({ behavior: 'smooth' });
      }
    } catch (err) {
      setError(err instanceof Error ? err.message : 'Error al generar el AST');
    } finally {
      setIsLoadingAst(false);
    }
  };

  // Función para descargar el AST como SVG
  const handleDownloadAst = () => {
    if (!astSvg) return;

    const blob = new Blob([astSvg], { type: 'image/svg+xml' });
    const url = URL.createObjectURL(blob);
    const a = document.createElement('a');
    a.href = url;
    a.download = 'ast.svg';
    document.body.appendChild(a);
    a.click();
    document.body.removeChild(a);
    URL.revokeObjectURL(url);
  };

  const handleErrors = () => {
    // Lógica para manejar Errores
    console.log("Errores");
  };

  const handleSymbols = () => {
    // Lógica para manejar Símbolos
    console.log("Símbolos");
  };

  return (
    <div className='flex flex-col items-center justify-center min-h-screen py-2'>
      {/* Tus componentes de interfaz actuales... */}
      
      <div className='flex justify-between p-2 bg-black w-full'>
        {/* Botones existentes... */}
        <div className='flex space-x-2'>
          <button onClick={handleCreateFile} className='bg-black text-white px-4 py-2 rounded'>Crear Archivos</button>
          <button onClick={handleOpenFile} className='bg-black text-white px-4 py-2 rounded'>Abrir Archivos</button>
          <button onClick={handleSaveFile} className='bg-black text-white px-4 py-2 rounded'>Guardar</button>
        </div>
        <div className='flex space-x-2'>
          <button 
            onClick={handleAST} 
            className='bg-black text-white px-4 py-2 rounded'
            disabled={isLoadingAst}
          >
            {isLoadingAst ? 'Generando...' : 'AST'}
          </button>
          <button onClick={handleErrors} className='bg-black text-white px-4 py-2 rounded'>Errores</button>
          <button onClick={handleSymbols} className='bg-black text-white px-4 py-2 rounded'>Símbolos</button>
        </div>
      </div>
      
      {/* Editor Monaco... (mantén tu código actual) */}
      <div className='flex flex-col w-full' style={{ height: '50vh' }}>
        <Editor
          height='100%'
          defaultLanguage='javascript'
          theme='vs-dark'
          value={code}
          onChange={(value) => setCode(value || '')}
        />
      </div>
      
      {/* Botón de ejecución... (mantén tu código actual) */}
      <button
        className='bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded mt-2'
        onClick={handleExecute}
      >
        Ejecutar
      </button>
      
      {/* Sección de salida... (mantén tu código actual) */}
      <div className='flex flex-col items-center justify-center w-full' style={{ height: '50vh' }}>
        <h2>Salida:</h2>
        <div className='w-full bg-white border rounded p-4 overflow-auto h-full'>
          {output ? (
            <pre className='text-black'>{output}</pre>
          ) : (
            <p className='text-black'>No hay salida para mostrar.</p>
          )}
          {error && (
            <div className='bg-red-500 p-4 mt-2'>
              <h3 className='text-white'>Error:</h3>
              <pre className='text-white'>{error}</pre>
            </div>
          )}
          
          {/* Nuevo: Contenedor para mostrar el SVG del AST */}
          {astSvg && (
            <div ref={astContainerRef} className='mt-4 border-t pt-4'>
              <div className='flex justify-between items-center mb-2'>
                <h3 className='text-black font-bold'>Árbol Sintáctico Abstracto (AST):</h3>
                <button 
                  onClick={handleDownloadAst}
                  className='bg-blue-500 hover:bg-blue-700 text-white font-bold py-1 px-2 rounded text-sm'
                >
                  Descargar SVG
                </button>
              </div>
              <div 
                className='overflow-auto border p-2 bg-white' 
                style={{ maxHeight: '500px' }}
              >
                <div dangerouslySetInnerHTML={{ __html: astSvg }} />
              </div>
            </div>
          )}
        </div>
      </div>
    </div>
  );
}