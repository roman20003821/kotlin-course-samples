package edu.ukma.lecture5

fun main() {
    htmlPage {
        h1 {
            +"Приклад функціонального програмування"
        }
        p {
            +"Сьогодні дізнаємося як реалізовувати такий функціонал"
            a("https://kotlinlang.org/docs/lambdas.html") {
                +"Посилання на додаткові ресурси"
            }
            +"Синтаксис прикладу взятий з Kotlin/Js"
        }
    }
}

@DslMarker
annotation class HtmlElementBuilderMarker

interface HtmlElement {
    fun source(): String

    @HtmlElementBuilderMarker
    interface Builder<T : HtmlElement> {
        fun build(): T
    }
}

fun htmlPage(init: HtmlPage.Builder.() -> Unit): HtmlPage {
    val htmlPageBuilder = HtmlPage.Builder()
    htmlPageBuilder.init()
    return htmlPageBuilder.build()
}

class HtmlPage(val elements: List<HtmlElement>) : HtmlElement {
    class Builder : HtmlElement.Builder<HtmlPage> {
        private val elements = ArrayList<HtmlElement>()

        fun h1(init: H1.Builder.() -> Unit) {
            val h1Builder = H1.Builder()
            h1Builder.init()
            elements.add(h1Builder.build())
        }

        fun p(init: P.Builder.() -> Unit) {
            val pBuilder = P.Builder()
            pBuilder.init()
            elements.add(pBuilder.build())
        }

        override fun build(): HtmlPage {
            return HtmlPage(elements)
        }
    }

    override fun source(): String {
        return elements.fold("") { acc, htmlElement -> acc + htmlElement.source() }
    }
}

class H1(val text: String) : HtmlElement {
    class Builder : HtmlElement.Builder<H1> {
        private var text: String = ""

        operator fun String.unaryPlus() {
            text += this
        }

        override fun build(): H1 {
            return H1(text)
        }
    }

    override fun source(): String {
        return "<h1>$text</h1>"
    }
}

class P(
    val text: String,
    val links: List<A>,
) : HtmlElement {
    class Builder : HtmlElement.Builder<P> {
        private var text: String = ""
        private val links = ArrayList<A>()

        operator fun String.unaryPlus() {
            text += this
        }

        fun a(
            url: String,
            init: A.Builder.() -> Unit,
        ) {
            val aBuilder = A.Builder()
            aBuilder.url = url
            aBuilder.init()
            links.add(aBuilder.build())
        }

        override fun build(): P {
            return P(text, links)
        }
    }

    // source не дасть правильний результат, оскільки структра класу P потрібна лише для прикладу та не реалізована до кінця
    override fun source(): String {
        return text + links.fold("") { acc, a -> acc + a.source() }
    }
}

class A(
    val url: String,
    val text: String,
) : HtmlElement {
    class Builder : HtmlElement.Builder<A> {
        var url: String = ""
        private var source: String = ""

        operator fun String.unaryPlus() {
            source += this
        }

        override fun build(): A {
            return A(url, source)
        }
    }

    override fun source(): String {
        return "<a href=\"$url\">$text</a>"
    }
}
