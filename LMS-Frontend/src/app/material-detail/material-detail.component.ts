import { Component, OnInit, Input } from '@angular/core';
import { Subject } from '../subject';
import {NestedTreeControl} from '@angular/cdk/tree';
import {MatTreeNestedDataSource} from '@angular/material/tree';

import { ActivatedRoute } from '@angular/router';
import { SubjectService } from '../subject.service';
import { TREE_DATA } from '../util/material-tree-data';

interface MaterialNode{
  name: String;
  children? : MaterialNode[];
}

@Component({
  selector: 'app-material-detail',
  templateUrl: './material-detail.component.html',
  styleUrls: ['./material-detail.component.scss']
})
export class MaterialDetailComponent implements OnInit {

  treeControl = new NestedTreeControl<MaterialNode>(node => node.children);
  dataSource = new MatTreeNestedDataSource<MaterialNode>();

  TREE_DATA = TREE_DATA;

  menuLinks = ['Syllabus', 'Data', 'Memos', 'Archives']

  @Input() subject: Subject;

  constructor(
    private route: ActivatedRoute,
    private subjectService: SubjectService
  ) { 
    this.dataSource.data = TREE_DATA;
  }

  ngOnInit() {
    this.getSubject();
  }

  getSubject(): void{
    const id = +this.route.snapshot.paramMap.get('id');
    this.subjectService.getSubject(id)
    .subscribe(subject => this.subject = subject);
  }

  hasChild = (_: number, node: MaterialNode) => !!node.children && node.children.length > 0;

}
