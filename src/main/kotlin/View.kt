import kotlinx.html.classes
import react.*
import react.dom.*

open class View<Props, State> : RComponent<ViewProps, RState>() {
    override fun RBuilder.render() {
        div {
            attrs.classes = setOf<String>("container")
            h1 {
                attrs.classes = setOf<String>("title")
                +props.label
            }
        }
    }
}

fun RBuilder.view(handler: ViewProps.() -> Unit): ReactElement {
    return child(View::class) {
        this.attrs(handler)
    }
}

external interface ViewProps: RProps {
    var id: String
    var label: String
}