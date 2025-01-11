# Tout Doux Liste

ToDo list application made with android compose and firebase.

## Todosception (the ToDo of a ToDo app)

### Release 1

- UI/UX
  - [x] [edge-to-edge](https://developer.android.com/develop/ui/compose/layouts/insets?hl=fr), Windows inset and component behind system bar.
  - [x] List page
    - [x] Task list
      - [x] Show list
      - [x] Scrollable
    - [x] Add Button
    - [x] Task card
      - [x] Checkbox to set task to Done
      - [x] Date in card
  - [x] Edit page
    - [x] [Datepicker](https://developer.android.com/develop/ui/compose/components/datepickers) with calendar icon
    - [x] Advanced Time picker
    - [x] Basic Time picker (advanced are not user friendly)     
  - Navigation
    - [x] Click card to go to edit page
    - [x] Click add button go to edit page
    - [x] Animation
      - [ ] fix transition direction
    - [x] Pass data to edit page
  - [ ] [App bar](https://developer.android.com/develop/ui/compose/components/app-bars)
    - List Page
      - [x] Title
    - Edit Page
      - [x] Title
      - [ ] Back button
      - [ ] Delete
      - [ ] Validate / save
    - [ ] Fix android status bar color
- [ ] Data binding between database and UI
  - [ ] Create Entity
  - List Page
    - [x] Load and show stubbed task
    - [ ] ViewModel
    - [ ] Check task to set to DONE
    - [ ] Slide card to right or left to delete
      - [ ] Undo [snackbar](https://developer.android.com/develop/ui/compose/components/snackbar)
  - Edit Page
    - [x] Load stubbed data of task
    - [ ] Handle date and time
    - [ ] Save when navback
    - [ ] Delete task
  - [ ] Link to local database

### Backlog
  
- [ ] Category
- [ ] Category [Chip](https://developer.android.com/develop/ui/compose/components/chip) to filter list
- [ ] Sort list: DOING then DONE
- [ ] Design, [Material](https://m3.material.io/)
  - [ ] Theming
  - [ ] Shared app bar beetween screen
  - [ ] [Shared](https://developer.android.com/develop/ui/compose/animation/shared-elements?hl=fr) title and descriptionin transition between list and edit page
- [ ] Logo
- [ ] Accessibility, contentDescription,...
- [ ] Notifications
- [ ] Splash screen
- [ ] Multilingual

#### Cancelled

I want to use local database

- Firebase configuration
  - [ ] Create project in firebase console
  - [ ] Configure app
  - [ ] Create service to manage data
    - [ ] Create
    - [ ] Read
    - [ ] Update
    - [ ] Delete

### Goal

Publish on Play Store ?