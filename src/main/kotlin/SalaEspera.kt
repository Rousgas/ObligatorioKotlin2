import jdk.swing.interop.SwingInterOpUtils

class SalaEspera() {
    var pacientes:ArrayList<Paciente> = ArrayList()

    /*
    miramos el paciente que mayor prioridad tiene, si la prioridad es equivalente nos quedamos con el primero que llegó
     */
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
    /*
    Le pasamos lo necesario para llevar a cabo la simulación.
    p es el paciente que vamos a atender, si es por quemadura pasa directamente a derivados, ya que no hay medicos especializados
    con otra atencion requerida miramos su seguro y comparamos con los medicos de guardia
    si coincide se atiende, si no, se deriva
    dT y dI son los medicos de guardia que hay en ese momento
    r es el registro que llevamos de lo que pasa en la simulacion, guardamos paciente,doctor y turno
    por ultimo, eliminamos el paciente de la lista de espera

     */
    fun simulacion(p:Paciente,r:Registro,dT:Medico,dI:Medico){
        var seAtiende:Boolean
        if (p.atencion.equals(("quemadura laser"))){
            r.turno.pacientesDerivados += 1
            println("No hay médicos especializados en la atención que requiere el paciente")
            println(p)
            println(r.turno)
            println("Atendido el día " + r.dia)
            println("///////////////////////////////////////////////////////////////////")

            //Borramos el paciente de la sala de espera, se deriva a otra nave hospital porque no hay medicos especializados en quemaduras laser
            this.pacientes.forEach(){pac ->
                if (pac == p){
                    pac.prioridad = 0
                }
            }
            this.pacientes.removeIf{it.prioridad == 0}
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