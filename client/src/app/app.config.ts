import { ApplicationConfig, InjectionToken, isDevMode } from '@angular/core';
import { provideAnimations } from '@angular/platform-browser/animations';
import { provideState, provideStore } from '@ngrx/store';
import { provideStoreDevtools } from '@ngrx/store-devtools';
import { provideEffects } from '@ngrx/effects';
import { bankReducer } from './store/bank.reducer';
import * as bankEffects from './store/bank.effects';
import { environment } from '../environments/environment';
import { provideHttpClient } from '@angular/common/http';

export const API_URL = new InjectionToken<string>('API_URL');
export const CUSTOMER_API_VERSION = new InjectionToken<string>(
  'CUSTOMER_API_VERSION',
);
export const appConfig: ApplicationConfig = {
  providers: [
    provideAnimations(),
    provideHttpClient(),
    provideStore(),
    provideStoreDevtools({
      maxAge: 25,
      logOnly: !isDevMode(),
      autoPause: true,
      trace: false,
      traceLimit: 75,
      connectOutsideZone: true, // If set to true, the connection is established outside the Angular zone for better performance
    }),
    provideState({ name: 'bank', reducer: bankReducer }),
    provideEffects(bankEffects),
    { provide: API_URL, useValue: environment.apiUrl },
    { provide: CUSTOMER_API_VERSION, useValue: environment.customerApiVersion },
    provideAnimations(),
  ],
};
