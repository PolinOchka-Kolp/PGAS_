package ScienseSphere

import CommonComp.*
import common.date
import common.scienceSphere
import csstype.ClassName
import react.FC
import react.Props
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


val Item222 = FC { _: Props ->
    var plus by useState(1)
    h6 {
        +"2.2.2 Публикации в сборниках трудов и материалов конференции"
    }
    ol {
        for (value in 1..scienceSphere[5]!!.keys.size) {
            li {
                form {
                    className = ClassName("row")
                    InputDate {
                        title = "Дата"
                        text = scienceSphere[5]!![value]!!["Дата"]!!
                        set = {
                            scienceSphere[5]!![value]!!["Дата"] = it
                        }
                    }
                    InputText {
                        title = "Название статьи"
                        text = scienceSphere[5]!![value]!!["Название статьи"]!!
                        set = {
                            scienceSphere[5]!![value]!!["Название статьи"] = it
                        }
                    }
                    InputSelect {
                        title = "Уровень конференции"
                        values = arrayOf(
                            "Местный",
                            "Региональный",
                            "Ведомственный",
                            "Всероссийский",
                            "Международный"
                        )
                        text = scienceSphere[5]!![value]!!["Уровень конференции"]!!
                        set = {
                            scienceSphere[5]!![value]!!["Уровень конференции"] = it
                        }
                    }
                    InputText {
                        title = "Количество авторов статьи"
                        text = scienceSphere[5]!![value]!!["Количество авторов статьи"]!!
                        set = {
                            scienceSphere[5]!![value]!!["Количество авторов статьи"] = it
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
                                            name = "Item222"
                                            this.value = it
                                            currentValue = scienceSphere[5]!![value]!!["Издание"]!!
                                            set = {
                                                scienceSphere[5]!![value]!!["Издание"] = it
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
                                            name = "Item222"
                                            this.value = it
                                            currentValue = scienceSphere[5]!![value]!!["Издание"]!!
                                            set = {
                                                scienceSphere[5]!![value]!!["Издание"] = it
                                            }
                                        }
                                    }
                                }
                                td {
                                    InputCheckbox {
                                        title = "Наличие рецензии"
                                        this.value = scienceSphere[5]!![value]!!["Наличие рецензии"]!!
                                        set = {
                                            scienceSphere[5]!![value]!!["Наличие рецензии"] = it
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
            scienceSphere[5]!![plus + 1] = mutableMapOf(
                "Дата" to date(),
                "Название статьи" to "",
                "Уровень конференции" to "",
                "Количество авторов статьи" to "",
                "Издание" to "",
                "Наличие рецензии" to "",
            )
            plus++
        }
    }
}
