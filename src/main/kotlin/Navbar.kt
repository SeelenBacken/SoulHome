import kotlinx.browser.window
import kotlinx.html.classes
import kotlinx.html.js.onClickFunction
import react.*
import react.dom.a
import react.dom.div
import react.dom.li
import react.dom.ul

class Navbar : RComponent<NavbarProps, RState>() {
    override fun RBuilder.render() {
        div {
            attrs.classes = setOf<String>("tabs", "is-large")
            ul {
                for (tab in props.tabs) {
                    li {
                        a { +tab.label }
                        attrs {
                            onClickFunction = {
                                props.onSelectTab(tab)
                            }
                            if (tab == props.currentTab) {
                                attrs.classes = setOf<String>("is-active")
                            }
                        }
                    }
                }
            }
        }
    }
}

fun RBuilder.navbar(handler: NavbarProps.() -> Unit): ReactElement {
    return child(Navbar::class) {
        this.attrs(handler)
    }
}

external interface NavbarProps : RProps {
    var tabs: Set<Tab>
    var currentTab: Tab
    var onSelectTab: (Tab) -> Unit
}