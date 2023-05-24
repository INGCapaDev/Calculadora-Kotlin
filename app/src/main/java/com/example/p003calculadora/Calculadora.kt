package com.example.p003calculadora

class Calculadora(var num1: Int, var num2: Int) {

    fun sumar(): Int {
            return num1 + num2
        }

        fun restar(): Int {
            return num1 - num2
        }

        fun multiplicar(): Int {
            return num1 * num2
        }

        fun dividir(): Int{
            var total = 0
            if (num2 != 0){
                total = num1 / num2
            }
            return total
        }
    }
