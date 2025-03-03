package main

import "fmt"

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
}

