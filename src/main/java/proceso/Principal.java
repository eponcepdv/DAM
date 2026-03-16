package proceso;

import collections.Stack;

public class Principal {
    static void main() {
        Stack stack = new Stack();
        stack.push("Hola");
        stack.push("Adiós");
        stack.push("Que tal");
        Stack subStack = new Stack();


        subStack.push("Perro");
        subStack.push("Gato");

        // Prueba de métodos
        System.out.println("Pila vacía?: "+stack.isEmpty());
        System.out.println("Pila llena?: "+stack.isFull());
        System.out.println("Está limitada?: "+stack.isLimited());
        System.out.println("Pila con límite de capacidad: "+stack.maxLimit());
        System.out.println("Tamaño actual de la pila: "+stack.size());
        System.out.println("La pila contiene la cadena 'Hola'?: "+stack.contains("Hola"));
        System.out.println("Dato de la cima: "+stack.peek());
        System.out.println("Extraemos la cima: "+stack.pop());
        System.out.println("Dato de la cima nueva: "+stack.peek());
        System.out.println("Añadimos a la cima: Hola de nuevo");
        stack.push("Hola de nuevo");
        System.out.println("Dato de la cima nueva: "+stack.peek());
        stack.pushSubStack(subStack);
        System.out.println("Dato de la cima nueva: "+stack.peek());
        subStack = stack.popSubStack(3);
        System.out.println("Dato de la cima subStack: "+subStack.peek());
    }
}
