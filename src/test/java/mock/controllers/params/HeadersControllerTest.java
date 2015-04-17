package mock.controllers.params;

import io.vertx.ext.apex.RoutingContext;
import io.vertx.nubes.annotations.Controller;
import io.vertx.nubes.annotations.params.Header;
import io.vertx.nubes.annotations.routing.Path;

import java.util.Date;

@Controller("/headers/")
public class HeadersControllerTest {

	@Path("mandatory") 
	public void mandatoryHeader(RoutingContext context, @Header(value="X-Date", mandatory=true) Date date) {
		context.response().end(Long.toString(date.getTime()));
	}
	
	@Path("facultative")
	public void facultativeHeader(RoutingContext context, @Header("X-Date") Date date) {
		if (date == null) { // allowed
			context.response().end("null");
		} else {
			context.response().end(Long.toString(date.getTime()));
		}
	}
}
