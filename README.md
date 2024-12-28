# Tout Doux Liste

ToDo list application made with android compose and firebase.

## Todosception (the ToDo of a ToDo app)

### Release 1

- UI/UX
  - [x] [edge-to-edge](https://developer.android.com/develop/ui/compose/layouts/insets?hl=fr), Windows inset and component behind system bar.
  - [ ] List page
    - [x] Task list
      - [x] Show list
      - [x] Scrollable
    - [x] Add Button
    - [x] Task card
      - [x] Checkbox to set task to Done
      - [x] Date in card
  - [ ] Edit page
    - [x] [Datepicker](https://developer.android.com/develop/ui/compose/components/datepickers) with calendar icon
    - [x] Advanced Time picker
    - [x] Basic Time picker (advanced are not user friendly)     
  - Navigation
    - [ ] Click card to go to edit page
  - [ ] [App bar](https://developer.android.com/develop/ui/compose/components/app-bars)
    - List Page
      - [ ] Title
    - Edit Page
      - [ ] Title
      - [ ] Back button
      - [ ] Delete
      - [ ] Validate / save
- Firebase configuration
  - [ ] Create project in firebase console
  - [ ] Configure app
  - [ ] Create service to manage data
    - [ ] Create
    - [ ] Read
    - [ ] Update
    - [ ] Delete
- [ ] Data binding between firebase and UI
  - List Page
    - [ ] Load and show task
    - [ ] Check task to set to DON
    - [ ] Slide card to right or left to delete
      - [ ] Undo [snackbar](https://developer.android.com/develop/ui/compose/components/snackbar)
  - Task Page
    - [ ] Load data of task
    - [ ] Save when navback
    - [ ] Delete task

### Backlog
  
- [ ] Category
- [ ] Category [Chip](https://developer.android.com/develop/ui/compose/components/chip) to filter list
- [ ] Sort list: DOING then DONE
- [ ] Design, [Material](https://m3.material.io/)
- [ ] Logo
- [ ] Accessibility, contentDescription,...
- [ ] Notifications

### Goal

Publish on Play Store ?