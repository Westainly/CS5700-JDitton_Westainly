import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.coroutines.coroutineScope
import java.io.File

object TrackingServer {
    suspend fun startServer() = coroutineScope{
        embeddedServer(Netty, 8080){
            routing {
                get("/") {
                    call.respondText(File("index.html").readText(), ContentType.Text.Html)
                }

                post("/data"){
                    val data = call.receiveText()
                    TrackingSimulator.executeCommand(data)
                    call.respondText {"Success"}
                }
            }
        }.start(wait = true)
    }
}