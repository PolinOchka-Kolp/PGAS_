package CommonComp

//import react.dom.html.InputType
import common.date
import common.minDate
import csstype.ClassName
import react.FC
import react.Props
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.input
import react.dom.html.ReactHTML.p
import react.useState
import web.html.InputType

external interface InputDateProps : Props {
    var title: String
    var set: (String) -> Unit
    var text: String
}

val InputDate = FC<InputDateProps> { props ->
    var text by useState(props.text)
    div {
        className = ClassName("col-2 d-flex flex-column justify-content-between align-items-center")

        p {
            +props.title
        }
        input {
            defaultValue = text
            this.className = ClassName("form-select")
            type = InputType.date
            onChange = {
                props.set(it.target.value)
                text = it.target.value
            }
            min = minDate()
            max = date()
        }
    }
}