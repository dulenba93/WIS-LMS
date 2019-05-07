interface MaterialNode{
    name: String;
    children? : MaterialNode[];
}

export const TREE_DATA: MaterialNode[] = [
    {
      name: 'First Semester',
      children: [
        {
          name: 'Videos',
          children: [
            {name: 'Broccoli'},
            {name: 'Brussel sprouts'},
          ]
        }, {
          name: 'Documents',
          children: [
            {name: 'Pumpkins'},
            {name: 'Carrots'},
          ]
        },
      ]
    }, {
      name: 'Second Semester',
      children: [
        {
          name: 'Videos',
          children: [
            {name: 'Broccoli'},
            {name: 'Brussel sprouts'},
          ]
        }, {
          name: 'Documents',
          children: [
            {name: 'Pumpkins'},
            {name: 'Carrots'},
          ]
        },
      ]
    }, {
      name: 'Final Exam',
      children: [
        {
          name: 'Videos',
          children: [
            {name: 'Broccoli'},
            {name: 'Brussel sprouts'},
          ]
        }, {
          name: 'Documents',
          children: [
            {name: 'Pumpkins'},
            {name: 'Carrots'},
          ]
        },
      ]
    }
  ]