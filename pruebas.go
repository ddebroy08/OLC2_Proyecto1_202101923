package main

import (
	"fmt"
	"reflect"
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
}

