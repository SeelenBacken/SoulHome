package views

import View
import ViewProps
import react.RBuilder
import react.RState
import react.ReactElement

class ToDoView : View<ViewProps, RState>() {

}

fun RBuilder.toDoView(handler: ViewProps.() -> Unit): ReactElement {
    return child(ToDoView::class) {
        this.attrs(handler)
    }
}