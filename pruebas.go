package main

import (
	"fmt"
	"reflect"
    "strings"
)

var i int // Variable global

func main() {
    var x string = "prueba1" // Variable local
    switch x {
        case "prueba1":
            fmt.Println("Uno")
        case "prueba2":
            fmt.Println("Dos")
            break
        default:
            fmt.Println("Otro")
        }

    slice := []int{1, 2, 3} 
    tipoSlice := reflect.TypeOf(slice) 
    fmt.Println("Tipo de slice:", tipoSlice)
    fmt.Println(slice[1])

    slicess := []string {"hola", "mundo"}
    fmt.Println(strings.Join(slicess, " "))
    valorIndice := slice[2]
    fmt.Println(valorIndice)

    // Los slices dentro de un slice no tiene porque tener el mismo tamaño 
    matriz := [][]int{ 
        {1, 2, 3},      // Slice con 3 elementos 
        {4, 5},         // Slice con 2 elementos 
        {6, 7, 8, 9},   // Slice con 4 elementos 
    } 

    fmt.Println(matriz[1][1]) 

    // Definición e inicialización directa 
    numeros := []int{1, 2, 3, 4} 

    // Slice multidimensional inicial 
    mtx1 := [][]int{ 
        {1, 2, 3}, 
        {4, 5, 6}, 
        {7, 8, 9}, 
    } 

    // Agregar el slice `numeros` como una nueva fila 
    mtx1 = append(mtx1, numeros) 

    fmt.Println(mtx1) // 3 


}

