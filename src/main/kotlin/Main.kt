import kotlin.random.Random

fun main(args: Array<String>) {
    var sistema = Factoria.sistema()
    var sala1 = Factoria.salaEspera()
    var sala2 = Factoria.salaEspera()
    var sala3 = Factoria.salaEspera()
    var reg:Registro = Registro()
    var seg = 1
    var nDia = 0
    var d = 0
    var sala:Int
    var paciente:Paciente = Paciente()
    var t:Turno = Factoria.turnoMa()
    var docT:Medico = Factoria.medicoTrauma()
    var docI:Medico = Factoria.medicoInternista()


    do {
        nDia = verDia(seg)
        if (nDia != d){
            println("-------------------------- DÍA " + nDia + "-------------------------")
            d = nDia
        }

        reg.dia = nDia
        reg.turno = t

        if (seg%2 == 0){
            sala = masVacia(sala1,sala2,sala3)

            if (sala == 1){
                sala1.pacientes.add(Factoria.paciente())
            }
            if (sala == 2){
                sala2.pacientes.add(Factoria.paciente())
            }
            if (sala == 3){
                sala3.pacientes.add(Factoria.paciente())
            }
        }
        if (seg%4 == 0){
            sala = masLlena(sala1,sala2,sala3)

            if (sala == 1){

                paciente = sala1.llamarPaciente()
                reg.paciente = paciente

                sala1.simulacion(paciente,reg,docT,docI)

            }
            if (sala == 2){

                paciente = sala2.llamarPaciente()
                reg.paciente = paciente

                sala2.simulacion(paciente,reg,docT,docI)
            }
            if (sala == 3){

                paciente = sala3.llamarPaciente()
                reg.paciente = paciente

                sala3.simulacion(paciente,reg,docT,docI)
            }
        }
        if(seg%10 == 0){
            println("************************* CAMBIO DE TURNO*****************************")
            docT = Factoria.medicoTrauma()
            docI = Factoria.medicoInternista()

            /*
            if (t.turno.equals("Mañana")) t = Factoria.turnoTa()
            if (t.turno.equals("Tarde")) t = Factoria.turnoNo()
            if (t.turno.equals("Noche")) t = Factoria.turnoMa()
            */
            t = t.cambiarTurno(t.turno)
        }
        seg++
    }while (seg <= 210)
}
/*
Se le pasan las salas de espera, las compara y devuelve la sala que menos pacientes tiene
 */
fun masVacia(s1:SalaEspera, s2:SalaEspera,s3:SalaEspera):Int{
    var n1 = s1.pacientes.count()
    var n2 = s2.pacientes.count()
    var n3 = s3.pacientes.count()
    var menos = n1
    var n = 1

    if (n2 < menos){
        menos = n2
        n = 2
    }
    if (n3 < menos){
        menos = n3
        n = 3
    }
    if (n1 == n2 && n1 == n3){
        n = Random.nextInt(0,3)+1
    }
    if (menos == n1 && menos == n2){
        n = Random.nextInt(0,2)+1
    }
    if (menos == n2 && menos == n3){
        n = Random.nextInt(0,2)+2
    }
    if (menos == n1 && menos == n3){
        n = Random.nextInt(0,2)
        if (n == 0){
            n = 3
        }
    }

    return n
}
/*
Se le pasan las salas de espera, las compara y devuelve la sala que mas pacientes tiene
 */
fun masLlena(s1:SalaEspera,s2:SalaEspera,s3:SalaEspera):Int{
    var n1 = s1.pacientes.count()
    var n2 = s2.pacientes.count()
    var n3 = s3.pacientes.count()
    var mas = n1
    var n = 1

    if (n2 > mas){
        mas = n2
        n = 2
    }
    if (n3 > mas){
        mas = n3
        n = 3
    }
    if (n1 == n2 && n1 == n3){
        n = Random.nextInt(0,3)+1
    }
    if (mas == n1 && mas == n2){
        n = Random.nextInt(0,2)+1
    }
    if (mas == n2 && mas == n3){
        n = Random.nextInt(0,2)+2
    }
    if (mas == n1 && mas == n3){
        n = Random.nextInt(0,2)
        if (n == 0){
            n = 3
        }
    }

    return n
}
/*
mira el día que es según el segundo por el que va la simulación
no se como funcione lo del cambio de día en una galaxia muy lejana, pero
al tener el cambio de turno cada 10 segundos, he supuesto que el ciclo de un día
son 30 segundos
 */
fun verDia(s:Int):Int{
    var d = 0

    if (s <= 30) d = 1
    if (s > 30 && s <= 60) d = 2
    if (s > 60 && s <= 90) d = 3
    if (s > 90 && s <= 120) d = 4
    if (s > 120 && s <= 150) d = 5
    if (s > 150 && s <= 180) d = 6
    if (s > 180 && s <= 210) d = 7

    return d
}