import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LocationHomeComponent} from "./location-home/location-home.component";
import {LocationListComponent} from "./location-list/location-list.component";
import {LocationEditComponent} from "./location-edit/location-edit.component";

const routes: Routes = [
  {
    path: '',
    component: LocationHomeComponent,
  },
  {
    path: 'list',
    component: LocationListComponent,
  },
  {
    path: 'new',
    component: LocationEditComponent,
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LocationRouting {
}
