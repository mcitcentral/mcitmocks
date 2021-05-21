import Header, { HeaderProps } from "./Header";
import { Story } from "@storybook/react";

export default {
  title: "Header",
  component: Header
};

// @ts-ignore
const Template: Story<HeaderProps> = args => <Header {...args} />;

export const Default = Template.bind({});

Default.args = {
  user: null
};
