package ScienseSphere

import CommonComp.InputCheckbox
import CommonComp.InputDate
import CommonComp.InputRadio
import CommonComp.InputText
import common.date
import common.scienceSphere
import csstype.ClassName
import react.FC
import react.Props
import react.dom.html.ReactHTML
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.form
import react.dom.html.ReactHTML.h6
import react.dom.html.ReactHTML.li
import react.dom.html.ReactHTML.ol
import react.dom.html.ReactHTML.p
import react.dom.html.ReactHTML.table
import react.dom.html.ReactHTML.td
import react.dom.html.ReactHTML.tr
import react.useState
import kotlin.collections.set

external interface Item221Props : Props {
}

val Item221 = FC { _: Props ->
    var plus by useState(1)
    p {
        ReactHTML.h5 {
            +"2.2 Наличие у студента публикации в научном издании"
        }
    }
    h6 {
        +"2.2.1 Статьи в научном журнале"
    }
    ol {
        for (value in 1..scienceSphere[4]!!.keys.size) {
            li {
                form {
                    className = ClassName("row")
                    InputDate {
                        title = "Дата"
                        text = scienceSphere[4]!![value]!!["Дата"]!!
                        set = {
                            scienceSphere[4]!![value]!!["Дата"] = it
                        }
                    }
                    InputText {
                        title = "Название статьи"
                        text = scienceSphere[4]!![value]!!["Название статьи"]!!
                        set = {
                            scienceSphere[4]!![value]!!["Название статьи"] = it
                        }
                    }
                    InputText {
                        title = "Количество авторов статьи"
                        text = scienceSphere[4]!![value]!!["Количество авторов статьи"]!!
                        set = {
                            scienceSphere[4]!![value]!!["Количество авторов статьи"] = it
                        }
                    }
                    p {
                        +"Идексация"
                        table {
                            tr { //1 строчка
                                td {
                                    +"Русское"
                                }
                                listOf("Русское:Отсутствует", "Русское:-РИНЦ-", "Русское:ВАК-", "Русское:Ведущие издания").forEach {
                                    td {
                                        InputRadio {
                                            title = it.substringAfter(":")
                                            name = "Item221"
                                            this.value = it
                                            currentValue = scienceSphere[4]!![value]!!["Издание"]!!
                                            set = {
                                                scienceSphere[4]!![value]!!["Издание"] = it
                                            }
                                        }
                                    }
                                }
                            }
                            tr {
                                td {
                                    +"Зарубежное"
                                }
                                listOf("Зарубежное:Отсутствует", "Зарубежное:-РИНЦ-", "Зарубежное:ВАК-", "Зарубежное:Ведущие издания").forEach {
                                    td {
                                        InputRadio {
                                            name = "Item221"
                                            this.value = it
                                            currentValue = scienceSphere[4]!![value]!!["Издание"]!!
                                            set = {
                                                scienceSphere[4]!![value]!!["Издание"] = it
                                            }
                                        }
                                    }
                                }
                                td {
                                    InputCheckbox {
                                        title = "Наличие рецензии"
                                        this.value = scienceSphere[4]!![value]!!["Наличие рецензии"]!!
                                        set = {
                                            scienceSphere[4]!![value]!!["Наличие рецензии"] = it
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    button {
        +"✚"
        onClick = {
            scienceSphere[4]!![plus + 1] = mutableMapOf(
                "Дата" to date(),
                "Название статьи" to "",
                "Количество авторов статьи" to "",
                "Издание" to "",
                "Наличие рецензии" to "",
            )
            plus++
        }
    }
}
