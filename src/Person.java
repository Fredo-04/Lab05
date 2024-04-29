public class Person implements Comparable<Person> {
    private String nombre;
    private String apellidos;
    private int edad;

    public Person(String nombre, String apellidos, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getApellidos() {return apellidos;}

    public void setApellidos(String apellidos) {this.apellidos = apellidos;}

    public int getEdad() {return edad;}

    public void setEdad(int edad) {this.edad = edad;}

    @Override   //Sobrecarga de CompareTo.
    public int compareTo(Person otraPersona) {  //COMPARACION DE EDADES. 
        return this.edad - otraPersona.edad;
    }

    @Override
    public String toString() {
        return String.format("Nombre: %s, Apellidos: %s, Edad: %d", nombre, apellidos, edad);
    }
}
