import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
    <div class="ng-view"></div>
    <router-outlet></router-outlet>
  `
})
export class AppComponent {
  title = 'frontEnd';
}
