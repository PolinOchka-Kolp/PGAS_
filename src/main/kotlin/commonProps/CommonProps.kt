package commonProps

import CommonComp.InputCheckbox
import CommonComp.InputDate
import CommonComp.InputSelect
import CommonComp.InputText
import StudySphere.Item
import common.date
import csstype.ClassName
import react.FC
import react.Props
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.form
import react.dom.html.ReactHTML.h2
import react.dom.html.ReactHTML.h5
import react.dom.html.ReactHTML.li
import react.dom.html.ReactHTML.ol
import react.useState

external interface CommonProps : Props {
    var title: String
    var listItem: List<FC<Item>>
    var sphere: MutableMap<Int, MutableMap<Int, MutableMap<String, String>>>
    var setValue: (Int, MutableMap<Int, MutableMap<String, String>>) -> Unit
}

val CCommon = FC<CommonProps> { props ->
    var a by useState(0)
    div {
        ol {
            props.sphere.forEach {
                li {
                    +it.value.values.toString()
                }
            }
        }
    }
    h2 {
        +props.title
    }
    div {
        props.listItem.forEach {
            it {
                setValue = { num, newValue ->
                    props.setValue(num, newValue)
                    a++
                }
            }
        }
    }
}


external interface CommonItem : Props {
    var title: String
    var sphere: MutableMap<Int, MutableMap<String, String>>
    var inputText: List<String>
    var inputDate: String?
    var selectList: Map<String, Array<String>>
    var checkBoxList: List<String>
    var setValue: (MutableMap<Int, MutableMap<String, String>>) -> Unit
}


val CCommonItem = FC<CommonItem> { props ->
    var plus by useState(1)
    h5 {
        +props.title
    }

    ol {
        for (value in 1..props.sphere.keys.size) {
            li {
                form {
                    className = ClassName("row")
                    props.inputDate?.let {
                        InputDate {
                            title = it
                            text = props.sphere[value]!![it]!!
                            set = { newValue ->

                                val newSphere = props.sphere
                                newSphere[value]!![it] = newValue

                                props.setValue(newSphere)
                            }
                        }
                    }

                    props.inputText.map {
                        InputText {
                            title = it
                            text = props.sphere[value]!![it]!!
                            set = { newValue ->
                                val newSphere = props.sphere
                                newSphere[value]!![it] = newValue
                                props.setValue(newSphere)
                            }
                        }
                    }

                    props.selectList.map { sel ->
                        InputSelect {
                            title = sel.key
                            values = sel.value
                            text = props.sphere[value]!![sel.key]!!
                            set = { newValue ->
                                val newSphere = props.sphere
                                newSphere[value]!![sel.key] = newValue
                                props.setValue(newSphere)
                            }
                        }
                    }
                    props.checkBoxList.map { check ->
                        InputCheckbox {
                            title = check
                            this.value = props.sphere[value]!![check]!!
                            set = {
                                val newSphere = props.sphere
                                newSphere[value]!![check] = it
                                props.setValue(newSphere)
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
            val list = props.selectList.keys.associateWith { "" }
            val dateList =
                if (props.inputDate != null) mapOf(props.inputDate!! to date()) else emptyMap()

            props.sphere[plus + 1] = (
                    dateList +
                            props.inputText.associateWith { "" } + props.checkBoxList.associateWith { "" }
                            + list).toMutableMap()
            plus++
        }
    }
}

