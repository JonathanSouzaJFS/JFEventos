package br.jfeventos.testutils

import br.jfeventos.domain.model.Event

object EventDataFactory {

    fun createEventList() =
        listOf(
            createEvent(),
            createEvent()
        )

    fun createEvent() =
        Event(
            id = 1,
            image = "https://passevip.com.br/wp-content/uploads/2018/04/2018-04-23-como-aumentar-o-alcance-e-atrair-publico-para-seu-evento.jpg",
            title = "Festa Intension Manaus",
            description = "Festa Insension Manaus, tudo sobre sua festa. Venha curtir conosco.Venha curtir conosco.Venha curtir conosco.Venha curtir conosco.Venha curtir conosco.Venha curtir conosco.Venha curtir conosco.Venha curtir conosco.Venha curtir conosco.",
            longitude = "-60.0261",
            latitude = "-3.10719",
            date = 27344610,
            price = 89.99.toBigDecimal()
        )
}