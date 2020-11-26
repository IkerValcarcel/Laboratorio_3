package LinkedList;

public interface ICircularLinkedList<T> {
    public void setDescr(String nom); // Añade el nombre como descripción de la lista
    public String getDescr(); // Devuelve la descripción de la lista
    public T removeFirst(); // Elimina el primer elemento de la lista
    public T removeLast(); // Elimina el último elemento de la lista
    public T remove(T elem); // Elimina un elemento concreto de la lista
    public T first(); // Da acceso al primer elemento de la lista
    public T last(); // Da acceso al último elemento de la lista
    public boolean contains(T elem); // Determina si la lista contiene un elemento concreto
    public T find(T elem); // Determina si la lista contiene un elemento concreto, y devuelve su referencia, null en caso de que no esté
    public boolean isEmpty(); // Determina si la lista está vacía
    public int size(); // Determina el número de elementos de la lista
    public IteratorCLL<T> iterator(); // Devuelve un iterador a los elementos de la lista
}
