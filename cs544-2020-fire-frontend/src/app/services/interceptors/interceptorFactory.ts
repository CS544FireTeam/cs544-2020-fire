import { Injector } from "@angular/core";
import { InterceptorService } from "./interceptor.service";

export function interceptorFactory(injector: Injector) {
    return new InterceptorService(injector);
}