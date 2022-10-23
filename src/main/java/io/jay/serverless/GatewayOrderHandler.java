package io.jay.serverless;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

import java.util.List;

public class GatewayOrderHandler extends SpringBootRequestHandler<APIGatewayProxyRequestEvent, List<Order>> {
}
