package app

import common.jsonCreate
import org.w3c.dom.url.URL
import org.w3c.files.Blob
import org.w3c.files.BlobPropertyBag
import react.FC
import react.Props
import react.dom.html.ReactHTML.a
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.input
import react.useRef
import react.useState
import tools.createZip
import web.file.FileList
import web.html.HTMLAnchorElement
import web.html.HTMLInputElement
import web.html.InputType

val CDownload = FC<Props>("CDownload") {
    val linkRef = useRef<HTMLAnchorElement>()
    val inputRef = useRef<HTMLInputElement>()
    var files by useState<FileList>()
    div {
        input {
            type = InputType.file
            multiple = true
            this.ref = inputRef
            onChange = {
                files = it.target.files!!
            }
        }
    }
    div {
        button {
            +"Сбросить файлы"
            onClick = {
                inputRef.current!!.value = ""
            }
        }
    }
    div {
        button {
            +"Сформировать архив"
            onClick = {
                val jsonBlob = Blob(arrayOf(jsonCreate()), BlobPropertyBag("text/plain"))
                files?.let{
                    val archive = createZip(it, jsonBlob)
                    archive.then { blob ->
                        val url = URL.createObjectURL(blob)
                        linkRef.current!!.href = url
                        linkRef.current!!.download = "files.zip"
                    }
                }

            }
        }
    }
    div {
        a {
            +"Скачать архив"
            this.ref = linkRef
        }
    }
}