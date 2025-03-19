'use client';
import { Editor } from '@monaco-editor/react';
import { useState } from 'react';

const API_URL = 'http://localhost:5120';

export default function Home() {
  const [code, setCode] = useState<string>('');
  const [error, setError] = useState<string>('');
  const [output, setOutput] = useState<string>('');

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

  const handleAST = () => {
    // Lógica para manejar AST
    console.log("AST");
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
      <div className='flex justify-between p-2 bg-black w-full'>
        <div className='flex space-x-2'>
          <button onClick={handleCreateFile} className='bg-black text-white px-4 py-2 rounded'>Crear Archivos</button>
          <button onClick={handleOpenFile} className='bg-black text-white px-4 py-2 rounded'>Abrir Archivos</button>
          <button onClick={handleSaveFile} className='bg-black text-white px-4 py-2 rounded'>Guardar</button>
        </div>
        <div className='flex space-x-2'>
          <button onClick={handleAST} className='bg-black text-white px-4 py-2 rounded'>AST</button>
          <button onClick={handleErrors} className='bg-black text-white px-4 py-2 rounded'>Errores</button>
          <button onClick={handleSymbols} className='bg-black text-white px-4 py-2 rounded'>Símbolos</button>
        </div>
      </div>
      <div className='flex flex-col w-full' style={{ height: '50vh' }}>
        <Editor
          height='100%'
          defaultLanguage='javascript'
          theme='vs-dark'
          value={code}
          onChange={(value) => setCode(value || '')}
        />
      </div>
      <button
        className='bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded mt-2'
        onClick={handleExecute}
      >
        Ejecutar
      </button>
      <div className='flex flex-col items-center justify-center w-full' style={{ height: '50vh' }}>
        <h2>Output:</h2>
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
        </div>
      </div>
    </div>
  );
}