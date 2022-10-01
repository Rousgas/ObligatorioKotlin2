import kotlin.random.Random

object Factoria {
    fun sistema() = Turno("mañana",0,0)
    fun salaEspera() = SalaEspera()
    var seguro1 = crearSeguro1()
    fun medicoTrauma() = Medico(crearNIDI(), crearNombre(),"traumatologia", seguro1, crearSeguro2(seguro1))
    fun medicoInternista() = Medico(crearNIDI(), crearNombre(),"internista", seguro1, crearSeguro2(seguro1))
    fun paciente() = Paciente(crearNIDI(), crearNombre(), crearSeguro1(), crearAtencion(), crearPrio())

    fun crearNIDI():Int{
       var n:Int
       n = Random.nextInt(0,101)
       return n
    }

    fun crearNombre():String{
        var cad= ""
        var n:Int

        n = Random.nextInt(0,4)
        if (n == 0) cad = "Chewie"
        if (n == 1) cad = "Padme"
        if (n == 2) cad = "Kylo"
        if (n == 3) cad = "Han"

        return cad
    }

    fun crearSeguro1():String{
        var cad= ""
        var n:Int

        n = Random.nextInt(0,3)
        if (n == 0) cad = "Sanitroopers"
        if (n == 1) cad = "Vaderslas"
        if (n == 2) cad = "Yodacare"

        return cad
    }

    fun crearSeguro2(s1:String):String{
        var cad= ""
        var n:Int

        do {
            n = Random.nextInt(0, 3)
            if (n == 0) cad = "Sanitroopers"
            if (n == 1) cad = "Vaderslas"
            if (n == 2) cad = "Yodacare"
        }while (s1.equals(cad))

        return cad
    }

    fun crearAtencion():String{
        var cad = ""
        var n:Int
        n = Random.nextInt(0,3)
        if (n == 0) cad = "quemadura laser"
        if (n == 1) cad = "impacto chorritronico"
        if (n == 2) cad = "otros"
        return cad
    }

    fun crearPrio():Int{
        var n:Int
        n = Random.nextInt(0,3) + 1
        return n
    }
}