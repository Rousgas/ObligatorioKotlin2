class Paciente(var NIDI:Int = 0, var nombre:String = "", var seguro:String = "", var atencion:String = "", var prioridad:Int = 0) {
    override fun toString(): String {
        return "Paciente(NIDI=$NIDI, nombre='$nombre', seguro='$seguro', atencion='$atencion', prioridad=$prioridad)"
    }
}