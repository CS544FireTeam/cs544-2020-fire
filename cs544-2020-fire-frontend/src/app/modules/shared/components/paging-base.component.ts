import {MatSort} from "@angular/material/sort";
import {ViewChild} from "@angular/core";
import {MatTableDataSource} from "@angular/material/table";
import CheckedItem from "../models/checked-item.model";

export abstract class PagingBaseComponent<T extends CheckedItem> {
  displayedColumns: string[];
  ELEMENT_DATA: T[] = [];
  dataSource: MatTableDataSource<T>;

  length = 100;
  pageIndex = 0;
  pageSize = 10;
  pageSizeOptions = [1, 2, 5, 10];

  // @ts-ignore
  @ViewChild(MatSort) sort: MatSort;

  abstract setDisplayedColumns();

  protected constructor() {
    this.setDisplayedColumns();
  }

  ngOnInit(elementData: T[]) {
    this.ELEMENT_DATA = elementData;
    this.loadData(0, this.pageSize);

  }

  onPageChange(e) {
    this.pageIndex = e.pageIndex;
    this.pageSize = e.pageSize;
    this.loadData(this.pageIndex, this.pageSize);
  }

  loadData(pageIndex, pageSize) {
    this.dataSource = new MatTableDataSource<T>(this.ELEMENT_DATA.slice(pageIndex, pageIndex + pageSize));
    this.dataSource.sort = this.sort;
  }

  selectAll() {
    this.ELEMENT_DATA.forEach(elm => {
      elm.isChecked = !elm.isChecked;
    });
  }

  ngAfterViewInit(): void {
    this.dataSource.sort = this.sort;
  }
}
