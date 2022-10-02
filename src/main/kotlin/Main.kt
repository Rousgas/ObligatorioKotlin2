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
    var turno:Turno = Turno()
    var docT:Medico = Factoria.medicoTrauma()
    var docI:Medico = Factoria.medicoInternista()
    var seAtinede:Boolean



    do {
        nDia = verDia(seg)
        if (nDia != d){
            println("-------------------------- DÍA " + nDia + "-------------------------")
            d= nDia
        }

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
                reg.dia = nDia

                sala1.simulacion(paciente,reg,docT,docI)

            }
            if (sala == 2){

                paciente = sala2.llamarPaciente()
                reg.paciente = paciente
                reg.dia = nDia

                sala2.simulacion(paciente,reg,docT,docI)
            }
            if (sala == 3){

                paciente = sala3.llamarPaciente()
                reg.paciente = paciente
                reg.dia = nDia

                sala3.simulacion(paciente,reg,docT,docI)
            }
        }
        seg++
    }while (seg <= 80)
}

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

fun verDia(s:Int):Int{
    var d = 0

    if (s <= 86400) d = 1
    if (s > 86400 && s <= 172800) d = 2
    if (s > 172800 && s <= 259200) d = 3
    if (s > 259200 && s <= 345600) d = 4
    if (s > 345600 && s <= 432000) d = 5
    if (s > 432000 && s <= 518400) d = 6
    if (s > 518400 && s <= 604800) d = 7

    return d
}