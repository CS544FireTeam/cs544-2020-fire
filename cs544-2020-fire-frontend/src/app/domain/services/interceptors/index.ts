import { HTTP_INTERCEPTORS} from '@angular/common/http';
import { Injector } from '@angular/core';
import { InterceptorService } from './interceptor.service';
import { interceptorFactory } from './interceptorFactory';


export const httpIntercetptorProvider = [
  {provide : HTTP_INTERCEPTORS, 
    useClass :InterceptorService,
    useFactory: interceptorFactory,
    deps: [Injector],
     multi : true}
];