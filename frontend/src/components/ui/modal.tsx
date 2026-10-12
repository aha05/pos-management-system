import type { ReactNode } from "react";
import { X } from "lucide-react";

type ModalProps = {
  title: string;
  onClose: () => void;
  children: ReactNode;
  footer?: ReactNode;
};

export function Modal({ title, onClose, children, footer }: ModalProps) {
  return (
    <div
      className="modal-backdrop"
      role="presentation"
      onMouseDown={(event) => {
        if (event.target === event.currentTarget) onClose();
      }}
    >
      <section
        className="merchant-modal edit-modal"
        role="dialog"
        aria-modal="true"
        aria-labelledby="edit-section-title"
      >
        <button type="button" className="modal-close" aria-label="Close" onClick={onClose}>
          <X />
        </button>
        <h2 id="edit-section-title">Edit {title}</h2>
        <div className="edit-modal-body">{children}</div>
        {footer && <div className="edit-modal-footer">{footer}</div>}
      </section>
    </div>
  );
}
