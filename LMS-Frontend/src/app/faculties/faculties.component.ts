import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { Faculty } from '../faculty';
import { FacultyService } from '../faculty.service';

// import {Map}  from 'ol/Map';
// import {View} from 'ol/View';
// import {Feature} from 'ol/Feature';
// import TileLayer from 'ol/layer/Tile'
// import * as OlLayer from 'ol/layer'
// import OSM from 'ol/source/OSM'
// import Vector from 'ol/source/Vector'
// import Point from 'ol/geom/Point'
// import Style from 'ol/style/Style'
// import Icon from 'ol/style/Icon'
// import * as proj from 'ol/proj';
// import Overlay from 'ol/Overlay.js'


@Component({
  selector: 'app-faculties',
  templateUrl: './faculties.component.html',
  styleUrls: ['./faculties.component.scss']
})
export class FacultiesComponent implements OnInit {

  @ViewChild("map")
  private mapElement: ElementRef;

  private map;

  faculties: Faculty[];

  constructor(
    private facultyService: FacultyService
  ) { }

  ngAfterViewInit() {
    this.map.setTarget(this.mapElement.nativeElement);
  }

  ngOnInit() {
    // this.map = new Map({
    //   layers: [
    //     new TileLayer({
    //       source: new OSM()
    //     })
    //   ],
    //   view: new View({
    //     center: proj.transform([19.844376, 45.253076], "EPSG:4326", "EPSG:3857"),
    //     zoom: 18,
    //     maxZoom: 19
    //   })
    // });

    // let locations = [];

    // let noviSad = new Feature({
    //   geometry: new Point(proj.transform([19.844376, 45.253076], "EPSG:4326", "EPSG:3857")),
    //   name: "Univerzitet Singidunum",
    //   schools: "<ul><li>Technigal sciences</li><li>Economics</li><ul>"
    // });

    // let beograd = new Feature({
    //   geometry: new Point(proj.transform([20.478852, 44.782189], "EPSG:4326", "EPSG:3857")),
    //   name: "Univerzitet Singidunum",
    //   schools: "<ul><li>Technigal sciences</li><li>Economics</li><ul>"
    // })

    // locations.push(noviSad);
    // locations.push(beograd);

    // let vectorSource = new Vector({
    //   features: locations
    // });

    // this.map.addLayer(new OlLayer.Vector(
    //   {
    //     source: vectorSource
    //   }));

    this.getFaculties();
  }

  getFaculties(): void {
    this.facultyService.getFaculties()
      .subscribe(faculties => this.faculties = faculties);
  }

}
