class Registro(var medico: Medico = Medico(), var paciente: Paciente = Paciente(), var turno: Turno = Turno(), var dia:Int = 0) {


    fun verReg(){
        println(this.medico)
        println(this.paciente)
        println(this.turno)
        println("Atendido el día " + this.dia)
        println("//////////////////////////////////")
    }
}