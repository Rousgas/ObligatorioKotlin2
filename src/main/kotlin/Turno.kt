class Turno(var turno:String = "", var pacientesAtendidos:Int = 0, var pacientesDerivados:Int = 0) {
    override fun toString(): String {
        return "Turno(turno='$turno', pacientesAtendidos=$pacientesAtendidos, pacientesDerivados=$pacientesDerivados)"
    }

    fun cambiarTurno(tu:String):Turno{
        var tCambiado:Turno = Turno()

        if (tu.equals("Mañana")){
            tCambiado = Factoria.turnoTa()
        }
        if (tu.equals("Tarde")){
            tCambiado = Factoria.turnoNo()
        }
        if (tu.equals("Noche")){
            tCambiado = Factoria.turnoMa()
        }

        return tCambiado
    }
}