package collections;

import java.util.ArrayList;

public class Stack {
    private ArrayList<Object> pila;
    private int limiteCapacidad;

    public Stack() {
        this.pila = new ArrayList<>();
        this.limiteCapacidad = 0;
    }
    public Stack(int limiteCapacidad) {
        this.pila = new ArrayList<>(limiteCapacidad);
        this.limiteCapacidad = limiteCapacidad;
    }
    public Stack(ArrayList<Object> pila) {
        this.pila = pila;
        this.limiteCapacidad = 0;
    }
    public boolean isEmpty() {
        return pila.isEmpty();
    }
    public boolean isFull() {
        return (limiteCapacidad>0 && pila.size() == limiteCapacidad);
    }
    public boolean isLimited() {
        return limiteCapacidad > 0;
    }
    public int maxLimit() {
        return limiteCapacidad;
    }

    public int size() {
        return pila.size();
    }
    public void push(Object dato) throws StackOverflowException, StackException
    {
        if (isFull()) {
            throw new StackOverflowException("La pila está llena.");
        } else {
            if (isEmpty()) {
                pila.add(dato);
            } else {
                if (pila.getFirst().getClass().equals(dato.getClass())) {
                    pila.add(dato);
                } else {
                    throw new StackException("Argumento de tipo incompatible con el tipo de la pila.");
                }
            }
        }
    }
    public Object pop() throws StackEmptyException {
        if (isEmpty()) {
            throw new StackEmptyException("La pila está vacía");
        }
        else  {
            return pila.removeLast();
        }
    }
    public Object peek() throws StackEmptyException {
        if (isEmpty()) {
            throw new StackEmptyException("La pila está vacía");
        }
        else  {
            return pila.getLast();
        }
    }
    public boolean contains(Object dato) {
        if (isEmpty()) {
            throw new StackEmptyException("La pila está vacía");
        } else {
            return pila.contains(dato);
        }
    }
    public Stack popSubStack(int numDatos) throws StackEmptyException, StackOverflowException {
        Stack pilaAux = new Stack();
        int base;
        Object dato;
        if (pila.isEmpty()) {
            throw new StackEmptyException("La pila está vacía");
        } else if (numDatos > pila.size()) {
            throw new StackOverflowException("La pila tiene menos datos que los solicitados.");
        } else {
            base = pila.size()-1-(numDatos-1);
            for (int i = 1; i <= numDatos; i++) {
                dato = pila.get(base++);
                pilaAux.push(dato);
            }
        }
        return pilaAux;

    }
    public void pushSubStack(Stack pilaNueva) {

        if (pilaNueva.isEmpty()) {
            throw new StackEmptyException("¡La pila a añadir está vacía!");
        } else {
            for (int i = 0; i < pilaNueva.size(); i++) {
                pila.add(pilaNueva.pop());
            }
        }
    }

}
