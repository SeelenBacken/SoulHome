package views

import View
import ViewProps
import kotlinx.html.classes
import react.dom.*
import react.*

class HomeView : View<ViewProps, RState> () {
    override fun RBuilder.render() {
        div {
            attrs.classes = setOf<String>("container")

            h1 {
                attrs.classes = setOf<String>("title")
                +"Home"
            }
            section {
                attrs.classes = setOf<String>("section")
                p {
                    +"This is the base Structure for my own small smarthome System. Right now there is not much here."
                }

                p {
                    +"There is no function right now, this is just a basic Frontend. Feel free to check out our Roadmap or Git."
                }

                ul {
                    li {
                        a {
                            attrs.href = "https://github.com/SeelenBacken/SoulHome"
                            +"Github"
                        }
                    }

                    li {
                        a {
                            attrs.href = "https://app.productstash.io/roadmaps/5f8fe97357feb10029bd0d84/public#current"
                            +"Roadmap"
                        }
                    }
                }
            }
        }
    }
}

fun RBuilder.homeView(handler: ViewProps.() -> Unit): ReactElement {
    return child(HomeView::class) {
        this.attrs(handler)
    }
}