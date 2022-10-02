class SalaEspera() {
    var pacientes:ArrayList<Paciente> = ArrayList()

    fun llamarPaciente():Paciente{
        var p:Paciente = this.pacientes[0]

        for (i in 0 .. this.pacientes.size-1){
            if (i>=1){
                if (this.pacientes[i].prioridad < this.pacientes[i-1].prioridad){
                    p = this.pacientes[i]
                }
            }
        }

        return p
    }

    fun simulacion(p:Paciente,r:Registro,dT:Medico,dI:Medico){
        var seAtiende:Boolean
        if (p.atencion.equals(("quemadura laser"))){
            r.turno.pacientesDerivados += 1
        }else{
            if (p.atencion.equals(("impacto chorritronico"))){
                r.medico = dT
            }else{
                r.medico = dI
            }

            seAtiende = r.medico.comprobarSeguro(r.paciente)
            if (seAtiende){
                r.turno.pacientesAtendidos += 1
            }else{
                r.turno.pacientesDerivados += 1
            }
            r.verReg()

            this.pacientes.forEach(){pac ->
                if (pac == p){
                    pac.prioridad = 0
                }
            }
            this.pacientes.removeIf{it.prioridad == 0}
        }
    }
}