import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { Article } from '../article';
import { NEWS } from '../mock-news';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  links = ['Formal', 'Health', 'Sports'];
  news = NEWS;

  constructor() { }

  ngOnInit() {
  }

}
