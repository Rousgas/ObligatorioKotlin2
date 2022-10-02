class Medico(var NIDI:Int = 0, var nombre:String = "", var especialidad:String = "", var seguro1:String = "", var seguro2:String = "") {
    override fun toString(): String {
        return "Medico(NIDI=$NIDI, nombre='$nombre', especialidad='$especialidad', seguro1='$seguro1', seguro2='$seguro2')"
    }
    /*
        comprueba si el seguro del paciente corresponde a los seguros para los que trabaja el medico
     */
    fun comprobarSeguro(p:Paciente):Boolean{
        var b = false

        if (p.seguro.equals(this.seguro1) || p.seguro.equals(this.seguro2)){
            b = true
        }

        return b
    }
}