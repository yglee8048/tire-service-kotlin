package tire.com

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TireClientApplication

fun main(args: Array<String>) {
    runApplication<TireClientApplication>(*args)
}