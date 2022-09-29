import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'dateFormatterPipe'
})
export class DateFormatterPipe implements PipeTransform {

  transform(value: string | Date, ...args: any[]): string {
    if(value instanceof Date){
      return value.toDateString();
    }
    else {
      return value.split('T')[0]
    }
  }

}
