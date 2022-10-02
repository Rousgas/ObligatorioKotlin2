class Turno(var turno:String = "Mañana", var pacientesAtendidos:Int = 0, var pacientesDerivados:Int = 0) {
    override fun toString(): String {
        return "Turno(turno='$turno', pacientesAtendidos=$pacientesAtendidos, pacientesDerivados=$pacientesDerivados)"
    }
}