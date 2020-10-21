package views

import View
import ViewProps
import kotlinx.html.classes
import react.*
import react.dom.*

class CalendarView : View<ViewProps, RState>() {
    override fun RBuilder.render() {
        div {
            attrs.classes = setOf<String>("container")
            h1 {
                attrs.classes = setOf<String>("title")
                +"Calendar"
            }
            p {
                +"A Placeholder for a calendar"
            }
        }
    }
}

fun RBuilder.calendarView(handler: ViewProps.() -> Unit): ReactElement {
    return child(CalendarView::class) {
        this.attrs(handler)
    }
}