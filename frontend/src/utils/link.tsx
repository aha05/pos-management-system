import type { AnchorHTMLAttributes } from "react";

export const Link = ({
  href,
  ...props
}: AnchorHTMLAttributes<HTMLAnchorElement> & { href: string }) => {
  return <a href={href} {...props} />;
}
