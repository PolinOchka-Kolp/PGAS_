package app

import CCultureCommon
import CScienceCommon
import CSocietyCommon
import CSportCommon
import CStudyCommon
import CommonComp.InputText
import common.Config
import common.person
import csstype.ClassName
import csstype.Display
import csstype.FontWeight
import csstype.TextAlign
import emotion.react.css
import react.FC
import react.Props
import react.create
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.li
import react.dom.html.ReactHTML.ol
import react.dom.html.ReactHTML.p
import react.dom.html.ReactHTML.ul
import react.router.Route
import react.router.Routes
import react.router.dom.HashRouter
import react.router.dom.Link
import kotlin.collections.component1
import kotlin.collections.component2
import kotlin.collections.set

val CMenu = FC("Menu") { _: Props ->
    div {
        css {
            display = Display.grid
        }
        ul {
            listOf(
                "Учебная деятельность" to Config.studyPath,
                "Научно-исследовательская деятельность" to Config.sciencePath,
                "Общественная деятельность" to Config.societyPath,
                "Культурно-творческая деятельность" to Config.culturePath,
                "Спортивная деятельность" to Config.sportPath
            ).map {
                li {
                    Link {
                        +it.first
                        to = it.second
                    }
                }
            }
        }
    }
}

val App = FC { _: Props ->
    div {
        className = ClassName("container")
        ol {
            li {
                div {
                    p {
                        css {
                            textAlign = TextAlign.center
                            fontWeight = FontWeight.bold
                        }
                        +"Заявление"
                    }
                    p {
                        css {
                            textAlign = TextAlign.center
                        }
                        +"Прошу рассмотреть мою кандидатуру на получение повышенной государственной академической стипендии. Копию зачетной книжки, копии грамот и документов, подтверждающих соответствие критериям прилагаются и перечислены в таблице."
                    }
                }
            }
        }
        person.forEach { (key, value) ->
            InputText {
                title = key
                text = value
                set = {
                    person[key] = it
                }
            }
        }
        CDownload {

        }
        HashRouter {
            CMenu()
            Routes {
                Route {
                    path = Config.studyPath
                    element = CStudyCommon.create()
                }
                Route {
                    path = Config.sciencePath
                    element = CScienceCommon.create()
                }
                Route {
                    path = Config.societyPath
                    element = CSocietyCommon.create()
                }
                Route {
                    path = Config.culturePath
                    element = CCultureCommon.create()
                }
                Route {
                    path = Config.sportPath
                    element = CSportCommon.create()
                }
            }
        }
    }
}