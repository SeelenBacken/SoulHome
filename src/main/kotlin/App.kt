import kotlinx.html.classes
import kotlinx.html.id
import react.dom.*
import react.*
import views.calendarView
import views.homeView
import views.toDoView

class App: RComponent<AppProps,AppState>()  {

    override fun RBuilder.render() {
        navbar {
            tabs = state.tabList
            currentTab = state.currentTab
            onSelectTab = { tab ->
                setState {
                    currentTab = tab
                }
            }
        }

        state.currentTab.let { currentTab ->
            if (currentTab == state.homeTab) {
                homeView {
                    id = "home"
                    label = "Home"
                }
            } else if (currentTab == state.calendarTab) {
                calendarView {
                    id = "calendar"
                    label = "Calendar"
                }
            } else if (currentTab == state.toDoTab){
                toDoView {
                    id = "toDo"
                    label = "ToDo List"
                }
            } else {
                view {
                    id = currentTab.id
                    label = currentTab.label
                }
            }
        }
    }

    override fun AppState.init() {
        homeTab = Tab("home", "Home")
        calendarTab = Tab("calendar", "Calendar")
        toDoTab = Tab("toDo", "ToDo")
        tabList = setOf<Tab>(homeTab, toDoTab, calendarTab)
        currentTab = homeTab
    }
}

external interface AppProps: RProps {

}

external interface AppState: RState {
    var currentTab: Tab
    var tabList: Set<Tab>
    var homeTab: Tab
    var calendarTab: Tab
    var toDoTab: Tab
}