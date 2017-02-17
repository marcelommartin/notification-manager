import { NotificationManagerUiPage } from './app.po';

describe('notification-manager-ui App', () => {
  let page: NotificationManagerUiPage;

  beforeEach(() => {
    page = new NotificationManagerUiPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
